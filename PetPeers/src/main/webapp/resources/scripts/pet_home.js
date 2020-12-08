 function confirmBuy()
 {
	 alert("Buy Pet");
	 var answer=confirm("Are you sure you want to buy?");
	 if (answer==true)
	   {
		 alert("Now the Pet is yours");
	     return true;
	   }
	 else
	   {
	     return false;
	   }
 }
 
 