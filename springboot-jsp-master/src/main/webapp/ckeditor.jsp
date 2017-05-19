<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div id="pnEditor" style="width:692px;float:left">
	<textarea name ="edit" id ="edit" rows="10" class="ckeditor" cols="30"></textarea>
	<button id = "save" name = "save" onclick = "myFunction()">Save</button>	
	<script>
		CKEDITOR.replace('edit');    
	    var text = '${text}';	           
	    var editor = CKEDITOR.instances['edit'];        
	    editor.setData( text );  
	  </script>   
	  <script type="text/javascript">
	       	function myFunction() {
	       		var editor = CKEDITOR.instances['edit'];
	       		
	       	 var noidung = editor.document.getBody().getText();
	          $.ajax({
	        	    type : "POST",
	        	    url : "upload",
	        	    data : {
	        	        noidung:noidung
	        	    },
	        	    success : function(response){
	        	    	alert(response);
	        	    	window.location.href = "edit";
	        	    }
	        	});        
		       }
	       </script>
	       </div>       
</body>
</html>
