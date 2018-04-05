function enregistrement (formulaire)
{
	var prenom=formulaire.prenom.value;
	var nom=formulaire.nom.value;
	var login=formulaire.login.value;
	var email=formulaire.email.value;
	var pwd=formulaire.pwd.value;
	var retapez=formulaire.retapez.value;
	var ok=verif_formulaire_enregistrement(prenom,nom,login,email,pwd,retapez);
	if (ok)
		enregistre(prenom,nom,login,email,pwd);
}

function verif_formulaire_enregistrement(prenom,nom,login,email,pwd,retapez)
{
	if (prenom.length==0)
	{
		func_erreur("Prénom obligatoire");
		return false;
	}
	if (nom.length==0)
	{
		func_erreur("Nom obligatoire");
		return false;
	}
	if (login.length==0)
	{
		func_erreur("Login obligatoire");
		return false;
	}
	if (email.length==0)
	{
		func_erreur("Email obligatoire");
		return false;
	}
	if (pwd.length==0)
	{
		func_erreur("Mot de passe obligatoire");
		return false;
	}
	if (prenom.length>20)
	{
		func_erreur("Prénom trop long");
		return false;
	}
	if (nom.length>20)
	{
		func_erreur("Nom trop long");
		return false;
	}
	if (login.length>20)
	{
		func_erreur("Login trop long");
		return false;
	}
	if (email.length>20)
	{
		func_erreur("Email trop long");
		return false;
	}
	if (pwd.length>20)
	{
		func_erreur("Mot de passe trop long");
		return false;
	}
	if (pwd.length<8)
	{
		func_erreur("Mot de passe trop court");
		return false;
	}
	if (pwd!=retapez)
	{
		func_erreur("Le mot de passe retapé est différent");
		return false;
	}
	return true;
}

//MODIFIER LA SERVLET POUR PRENDRE EN COMPTE EMAIL
function enregistre(prenom,nom,login,email,pwd)
{
	console.log("Enregistrment de " + prenom);
	var url = "http://localhost:8080/FakeBook/CreateUser?login="+login+"&name="+nom+"&fname="+prenom+"&pwd="+pwd;
	if (!noConnection)
	{
		$.ajax({
			type:"POST",
			url:url,
			data:"login="+login+"&name="+nom+"&fname="+prenom+"&pwd="+pwd,
			datatype: "json",
			success: function(rep){ 
				alert("Vous vous êtes bien enregistré(e)");
			},
			error: function (jqXHR, textStatus, errorThrown){
				alert(textStatus);
			}
		});
	}
}