
<%@page import="Service.ServiceImages"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Imagenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/inicioFb.js"></script>
<script src="js/Main.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/carousel.css">
<link rel="stylesheet" href="css/main.css">
</head>

<body>
	<script type="text/javascript">
		cargarFbSDK();
		iniciarFb();
	</script>
	<div class="container">
		<div class="row">
			<h3 class="col-xs-6">InstagramEAFIT</h3>
			<input id="loginFbInput" class="col-xs-4" type="button"
				value="Iniciar con FB" onclick="loginFB()">
			<div>
				<p id="user" class="col-xs-6">Bienvenido :</p>
			</div>
		</div>
		<a href="#" class="btn btn-lg btn-success" onclick="verificarPermisos();">Agregar Imagen</a>
<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title" id="myModalLabel">Agregar Imagen</h4>
            </div>
            <div class="modal-body">
				<form action="upload" method="post" name="uploadForm"
					enctype="multipart/form-data">
					<div class="divForm">
						<p>Titulo</p>
						<input id="title" type="text" name="titulo">
					</div>
					<div class="divForm">
						<p>Descripcion</p>
						<textarea id="textArea" rows="1" cols="1" name="descripcion"></textarea>
					</div>
					<input type="file" name="uploadfile" />
					<input id="submit" name="submit" type="submit" value="upload" size="100" />
				</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
        </div>
    </div>
  </div>
</div>
<!-- 		<form action="upload" method="post" name="uploadForm" -->
<!-- 			enctype="multipart/form-data"> -->
<!-- 			<div class="divForm"> -->
<!-- 				<p>Titulo</p> -->
<!-- 				<input id="title" type="text" name="titulo"> -->
<!-- 			</div> -->
<!-- 			<div class="divForm"> -->
<!-- 				<p>Descripcion</p> -->
<!-- 				<textarea id="textArea" rows="1" cols="1" name="descripcion"></textarea> -->
<!-- 			</div> -->
<!-- 			<input type="file" name="uploadfile" /> -->
<!-- 			<input id="submit" name="submit" type="submit" value="upload" size="100" /> -->
<!-- 		</form> -->
	<ul class="imagesList"></ul>
	</div>
	<ul class="imagenes">
		<%
			String template = "<div class='row featurette'>"
					+ "<div class='col-md-7'>"
					+ "<h2 class='featurette-heading'>";
			String temp ="</h2><p class='lead'>";
			String template2="</p> </div>"
					+ "  <div class='col-md-5'>"
					+ "    <img class='featurette-image img-responsive' data-src='holder.js/500x500/auto' alt='500x500' src='";
			String terminacionTemplate = "</div>" + "</div>;";
			String li = "<li>";
			String endLi = "</li>";
			ServiceImages si = new ServiceImages();
			List<Imagenes> imag = si.retriveImages();
			String imagen;
			for (Imagenes img : imag) {
				// 				imagen = "<img "+"id=\""+img.getId()+"\" src=\""+img.getName()+"\">";
				imagen = template +img.getTitle()+temp+img.getDescription()+template2+ img.getName() + "'>" ;
				out.write(imagen);
				out.print("<span id='"+img.getId()+"' class='glyphicon glyphicon-remove' onClick='eliminarImagen(this.id)'' /> " + endLi+terminacionTemplate);
				//out.write(li+imagen+"\n");
			}
		%>
	</ul>
</body>
</html>