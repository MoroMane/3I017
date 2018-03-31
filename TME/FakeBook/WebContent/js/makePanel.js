function makeConnexionPanel()
{
	$("body").load("html/connexion.html");
}

function makeEnregistrementPanel()
{
	$("body").load("html/enregistrement.html");
}

function makeMdpLostPanel()
{
	$("body").load("html/mdp_lost.html");
}

function makeProfilPanel()
{
	$("body").load("html/profil.html");
}

function makeDecoPanel()
{
	$("body").load("html/deconnexion.html");
}
function makeMainPanel2(fromId,fromLogin,query)
{
	$("body").load("html/main.html");
}

function makeMainPanel(fromId,fromLogin,query)
{
	if (fromId==undefined)
		fromId=-1;
	env.fromId=fromId;
	env.msg=[]
	env.query=query;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	var s="";
	if (env.fromId < 0)
		$("body").load("html/main.html");
	else
	{
		if (!env.follows.has(env.fromId))
		{
			s+="<div id=\"title\"><h1>Page de " + fromLogin + "</h1></div>";
			s+="<div class = \"add\">";
			s+="<input type=\"button\" value=\"suivre\" onclick='Javascript:follow()' />";
			s+="</div></div>";
		}
		else
		{
			s+="<div id=\"title\"><h1>Page de " + fromLogin + "</h1></div>"
			s+="<div class = \"add\">";
			s+="<input type=\"button\" value=\"suivre\" onclick='Javascript:stopfollow()' />";
			s+="</div></div>";
		}
	}
	s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
	s+="<br>";
	s+="<div class = \"disco\"> <input type=\"button\" value=\"disco\" onclick='Javascript:disconnect()'/>";
	s+="</div></div>";
	s+="<div class = \"message\"></div>";
	$("body").html(s);
	completeMessages();
}