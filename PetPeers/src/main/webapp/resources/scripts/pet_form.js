function validateForm()
{

	let petName=document.getElementById("petname").value;
	let petAge=document.getElementById("petage").value;
	let petPlace=document.getElementById("petplace").value;
	
	if(petName==""||petAge==""||petPlace=="")
	{
		swal({
			title : "Oops!!",
			text : "All fields are mandatory",
			icon : "error"
		});
		return false;
		
	}
	
	else if(parseInt(petAge)<0 || parseInt(petAge)>99)
	{
		swal({
			title : "Oops!!",
			text : "Age should be 0 and 99 years",
			icon : "error"
		});
		return false;
	
	}
	else
	{
		return true;
	}
}