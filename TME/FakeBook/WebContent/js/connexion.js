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
	//Avec les servlets
	//login : 3408748 mdp: monmdp
	console.log("connection de " + login + ", mdp: " + password);
	var url = "Login";
	if (!noConnection)
	{
		$.ajax({
			type:"GET",
			url:url,
			data:"login="+login+"&pwd="+password,
			datatype: "JSON",
			success: function(rep)
			{
				responseConnexion(rep);
			},
			error: function (jqXHR, textStatus, errorThrown){alert(textStatus);},
		});
	}
	//En Local
	else
	{
		bool=false;
		i=0
		while (i<localusers.length)
		{
			if ((localusers[i].login==login) && (localusers[i].password==password))
			{
				bool=true;
				break;
			}
			i=i+1;
		}
		if (bool)
		{
			var key="ABCD";
			responseConnexion({"key":key,"id":localusers[i].id,"login":login,"follows":follows[localusers[i].id]});
		}
		else
			func_erreur("Login ou mot de passe incorrect");
	}
}

function responseConnexion(rep)
{	
	//Local
	if (noConnection)
	{
		if (rep.Error==undefined)
		{
			env.key=rep.key;
			env.id=rep.id;
			env.login=rep.login;
			if (rep.follows==undefined)
				env.follows=new Set();
			else
				env.follows=rep.follows;
			//for (var i=0;i<rep.follows.length;i++)
				//env.follows.add(rep.follows[i]);
			//alert(env.follows[1]);
		}
		/*
		else
		{
			follows[rep.id]=new Set();
			for (var i=0;i<rep.follows.length;i++)
				follows[rep.id].add(rep.follows[i]);
		}*/
		makeProfilPanel(rep.id,rep.login);
	}
	//Connecté
	else
	{
		//pour transformer la string en JSON
		var rep2= JSON.parse(rep);
		//Connecté
		if(rep2.Error!=undefined)
			func_erreur(rep2.Error);
		if (rep2.Error==undefined)
		{
			env.key=rep2.Key;
			env.id=rep2.Id;
			env.login=rep2.Login;
			if (rep2.Follows==undefined)
				env.follows=new Set();
			else
				env.follows=rep2.Follows;
			makeProfilPanel(rep2.Id,rep2.Login);
			//for (var i=0;i<rep.follows.length;i++)
				//env.follows.add(rep.follows[i]);
			//alert(env.follows[1]);
		}
	}
}

 