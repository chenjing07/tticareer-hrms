$(function(){
	var allVal='';
	//userName blur
	$("input[name='userName']").blur(function(allVal){
		var usernameVal = $(this).val();
		if(usernameVal==''){
			allVal='Account cannot be empty!';
			layerOpen(allVal);
		}
	});
	
	//password blur
	$("input[name='password']").blur(function(allVal){
		var paswVal = $(this).val();
		if(paswVal.length==''){
			allVal='Password is not correct!';
			layerOpen(allVal);
		}
	});
	
	//login button
	$("#login_btn").on('click',function(){
		 layer.open({
			type: 2
			,content: '登录中...'
			,time: 2
			
		 });
		 
		 
	        
		    $.ajax({
		    	type:"POST",
		    	url:"/authentication/login",
		    	data:$('#login-form').serialize(),
		    	dataType:'json',
		    	success:function(json){
		    		if(json.success){
		    			//alert(msg);
		    			window.location.href= 'http://localhost/index.html#dashboard'; 
		    		}else{
		    			alert("登录失败，请重试!");
		    		}
		    	}
			});
	});
	
	//general layer
	function layerOpen(allVal){
		console.log(allVal);
		layer.open({
			content: allVal,
			btn: 'I know'
		});
	}
	
	
});