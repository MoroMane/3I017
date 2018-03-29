diapo 25
diapo 29
diapo 34
diapo 55

ex utilisation ajax/js
function search(query){
	//var friends=($('#box_friends').get(0).checked)?1:0;
	var friends=0;
	//var query= $("#requete").val();
	var dataQuery='';
	if(query!==undefined)
		dataQuery='&query='+query;
	console.log(query);
	$.ajax({ 
		type: "GET",
		url: "ListMessage",
		data: (env.key===undefined? "": "key="+env.key)+dataQuery+"&friends="+friends,
		dataType: "json",
		success: RechercheCommentaire.traiteReponseJSON,
		error: function(jqXHR, textStatus, errorThrown){
			alert(textStatus);
			}
		});
}

