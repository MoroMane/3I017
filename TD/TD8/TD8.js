Semaine prochaine : interro

AJAX :
$.ajax ({
	type: "POST",
	URL: "votre_url_servlet",
	datatype: "json",
	success: function(rep),
	error: function (jqxhr, text status, errorThrown){}});

8.1 Connexion/Enregistrement
Question 1
	function connecte (login,password)
	{
		var idUser=78;
		var key="ABCD"
		if (!noConnection)
		{
			$.ajax({
				type:"POST",
				url:"Twister/login",
				data: "login="+login+"&password="+passwd,
				datatype: "json"
				success: function(rep){ connexionResponse(rep),
				error: function (jqxhr, text status, errorThrown){alert(textstatus);}
			})
		}
		else {
			connexionResponse({___});
		}
	}

Question 2

	function enregistre (prenom,nom,mail,login,password)
	{
		if (!noConnection)
		{
			$.ajax({
				type:"POST",
				url:"Twister/inscription",
				data: "prenom="+prenom+"&nom="+nom+"&mail="+mail+"&login="+login+"&password="+password,
				datatype: "json",
				success: function(rep){ enregistreResponse(rep);}
			})
		}
	}

8.2 - Recuperation des messages
Question 1
function completeMessage()
{
	if (!noConnection)
	{
		$.ajax({
			...
			url:"Twister/listMessage";
			data:"key="+env.key+"&query="+env.query+"&from="+env.fromId+"&id_max"+env.mindId+"&id_min=-1 &nb=10";
			sucess: function (rep){completeMessageResponse(rep);}
		})
	}
	else
	{
		//local
	}
}

8.3 Publications
A la suite dune Publication on veut rafraichir avec le nouveau message entrant de la listMessage
function refreshMessage()
{
	if (env.query==undefined)
	{
		return;
	}
	if (!noConnection)
	{
		$.ajax({
			type:"POST",
			url:"Twister/listMessage",
			data:"key="+env.key+"&query="+env.query+"&from="+env.fromId+"&id_max=-1 &id_min="+ env.maxId+ "&nb=-1",
			sucess : function(rep){ refreshMessageResponse(rep);}
		})
	}
}

function refreshMessageResponse (rep)
{
	var tab=JSON.parse(rep,revival)
	for (var i=tab.length-1;i>=0;i++)
	{
		var m=tab[i];
		$("#messages").prepend(m.getHTML());
		env.msg[m.id] = m;
		if (m.id > env.maxId)
			env.maxId = env.id;
		if (env.minId<0||(m.id<env.minId))
			env.minId = m.id;
	}
}

function new_message()
{

	var text=$("#text_new_message ").val();
	if (!noConnection)
	{
		$.ajax({
			type:"POST",
			url:"Twister/AddMessage",
			data:"key="+env.key+"&text="+text,
			datatype:"json",
			success: function(rep){new Message_response(rep)}
		})
	}
	else
	{
		new refreshMessageResponse(id, JSON_stringify(new Message(env.msg[id].comments.length+1,{"id":env.id,"login":env.login},text,new Date())));
	}
}

function newMessage_response(rep)
{

}
