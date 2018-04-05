function connexion (formulaire)
{
	var login=formulaire.login.value;
	var pass=formulaire.pass.value;
	var ok=verif_formulaire_connexion(login,pass);
	if (ok)
		connecte(login,pass);
}

function verif_formulaire_connexion(l,p)
{
	if (l.length==0)
	{
		func_erreur("Login obligatoire");
		return false;
	}
	if (p.length==0)
	{
		func_erreur("Mot de passe obligatoire")
		return false;
	}
	if (l.length>20)
	{
		func_erreur("Login trop long");
		return false;
	}
	return true;
}

function connecte(login,password)
{
	//Local
	var id=78;
	var key="ABCD";

	//Avec les servlets
	//login : 3408748 mdp: monmdp
	console.log("connection de " + login + ", mdp: " + password);
	var url = "http://localhost:8080/FakeBook/Login?login="+login+"&pwd="+password;
	if (!noConnection)
	{
		$.ajax({
			type:"POST",
			url:url,
			data: "login="+login+"&pwd="+password,
			datatype: "json",
			success: function(rep){ 
				responseConnexion(rep);
			},
			error: function (jqXHR, textStatus, errorThrown){
				alert(textStatus);
			}
		});
	}
	else 
		responseConnexion({"key":key,"id":id,"login":login,"follows":[2]});
}

function responseConnexion(rep)
{
	alert("OK");
	if (rep.erreur==undefined)
	{
		env.key=rep.key;
		env.id=rep.id;
		env.login=rep.login;
		env.follows=new Set();
		for (var i=0;i<rep.follows.length;i++)
			env.follows.add(rep.follows[i]);
	}
	if (noConnection)
	{
		follows[rep.id]=new Set();
		for (var i=0;i<rep.follows.length;i++)
			follows[rep.id].add(rep.follows[i]);
	}
	else
		func_erreur(rep.erreur);
	makeProfilPanel2(rep.id,rep.login);
}

