function init()
{
	nbConnection=true;
	env=new Object();
	SetVirtualDB();
	var m1=new Message("id42","3408748","ceci est un texte",new Date(),["comment1","comment2"]);
	document.getElementById("main").innerHTML=m1.getHTML();
}

function SetVirtualDB()
{
	localdb=[];
	follows=[];
	var a1={"id":1,"login":"sly"};
	var a2={"id:":2,"login":"fab"};
	var a3={"id":4, "login":"joe"};
	follows[1]=[2,4];
	follows[2]=new Set();
	follows[2].add(4);
	follows[4]=[1];
	//var c1=new Commentaire(1,user3,"hum",new Date());
	//var c2=...;
	localdb[1]=new Message(2,"user1","blabla",new Date(),"test");
	localdb[4]=new Message(4,"user2","hello",new Date());
}

function Message(id,login,text,date,comments)
{
	this.id=id;
	this.login=login;
	this.text=text;
	this.date=date;
	if (comments == undefined)
		comments=[];
	this.comments=comments;
}

Message.prototype.getHTML=function()
{
	var s="<div id=\"message\" Liste Message";
	s+="<br>";
	s+="Message: "+this.id;
	s+="</div>";

	//var s= "<div id=\"message\"" + this.id+ "class=message>";
	//s+= "<div class=\"text_message\">" + this.text + "</div>";
	//s+= "<div class=\"infos_message\">";
	//s+= "<span> Post de <span class=link.onclick=javascript.pageUser("+this.login+")>";
	//s+="</span></span></div></div>";
	return s;
}