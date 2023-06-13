/**
 * 
 */

 function calcjs(){
	 var n1 = parseInt(document.getElementById("n1").value)
	 var n2 = parseInt(document.getElementById("n2").value)
	 var op = document.getElementById("op").value
	 
	 var result = 0;
	 switch(op){
		 case "+": result = n1 + n2; break;
		 case "-": result = n1 - n2; break;
		 case "*": result = n1 * n2; break;
		 case "/": result = n1 / n2; break;
	 }

	console.log(result)
	
	var ans = document.getElementById("ans")
	ans.value = result
	
	 
 }
 
 