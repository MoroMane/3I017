function init()
{
	noConnection=true;
	env=new Object();
	SetVirtualDB();
}

function SetVirtualDB()
{
	localdb=[];
	var a1={"id":1,"login":"sly"};
	var a2={"id:":2,"login":"fab"};
	var a3={"id":4, "login":"joe"};
	follows=[];
	follows[1]=[2,4];
	follows[2]=new Set();
	follows[2].add(4);
	follows[4]=[1];
	var c1=new Commentaire(1,"user3","hum",new Date(),0);
	localdb[0]=new Message(41,"3408747","Bla",new Date());
	localdb[1]=new Message(42,"3408748","Blabla",new Date());
	localdb[2]=new Message(43,"3408749","Hello",new Date());
	localdb[3]=new Message(44,"3408750","Buenos Dias", new Date(),[c1]);
}

function getFromLocalDB(fromId,minId,maxId,nbMax)
{
	var tab=[];
	var nb=0;
	var f=new Set();
	if (fromId>0)
		f=follows[fromId];
	for (var i=localdb.length-1;i>=0;i--)
		tab[i]=localdb[i];
	return tab;
}