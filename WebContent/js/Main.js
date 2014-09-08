function eliminarImagen( id){
	$.ajax({
        url: "http://localhost:8080/Reto1Telematica/ws/imagenes/delete/"+id,
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
        	if (data =="true") {
				location.reload();
			}else {
				alert("error al eliminar la imagen");
			}
        }
	});
}