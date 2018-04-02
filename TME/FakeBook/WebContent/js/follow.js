function follow ()
{
	if (!noConnection){}
	else
		reponseFollow({});
}

function reponseFollow(rep)
{
	if(rep.erreur==undefined)
	{
		env.follows.add(env.fromId)
		if (noConnection)
		{
			follows[env.id].add(env.fromId);
		}
		$("#add").html("<img src=\"mon_image_ne_plus_suivre\" onclick='javascript.stopFollow()'/>");
	}
	else
		alert(rep.erreur);
}