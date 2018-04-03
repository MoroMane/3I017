8.4 - Photo de profil

public class UpoadPicture extends HTTPServlet
{
	private final String UPLOAD_DIRECTORY="/3I017/Fileserve/";
	protected void doPost(HTTPServletRequest req,HTTPServletResponse rep)
	{
		boolean isMultiPart=ServletFileUpload.isMultiPartContent(request);
		String key=""
		response.setContentType("application/json")
		Printwriter out= response.print...
	if (isMultiPart)
	{
		FileItemFactory factory=new DiskFileItemFactory();
		factory.setRepository(new File(filepath));
		ServletFileUpload upload=new ServletFileUpload(factory);
		try
		{
			List fileItem=upload.parseRequest(request);
			Iterator i =fileItem.Iterator();
			String filename="";
			while (i.hasNext())
			{
				FileItem fi=(FileItem) i.next()
				String fname=f.getFieldName();
				if (!fi.isFormField())
				{
					...
				}
			}
		}
}

Côté client :
<form id="form_uploadPicture">
<input itype="file" id=" isfile"\>
</form>

function performPictureSubmit()
{
	var formData=new FormData();
	fromData.append("key",env.key);
	fromData.append(env.id+"picture",$("#sfile")[0].files[0]);
	$.ajax({
		url
	})
}