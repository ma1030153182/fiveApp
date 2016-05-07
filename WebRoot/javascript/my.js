//
//
//$(
//	function(){
//		$(".add-custom-add").click(
//			alert("hello");
//			function(){
//				$.post(
//					"<%=basePath%>keFuAction_addCustom" ,
//						   					{
//						   						custom.customIdCard:$("#customIdCard").val(),
//						   						custom.customName:$("#customName").val(),
//						   						custom.customCompany:$("#customCompany").val(),
//						   						custom.customTel:$("#customTel").val(),
//						   						custom.customMabile:$("#customMabile").val(),
//						   						custom.customAddrass:$("#customAddrass").val(),
//						   						custom.customEmail:$("#customEmail").val(),
//						   						custom.customPost:$("#customPost").val(),
//						   					},
//						   					
//						   					
//						   					
//						   				function(data,status){
//						    alert("Data: " + data + "nStatus: " + status);
//					  }
//					
//				)
//			}
//		);
//	}
//)
//$(function(){
//	$(".add-custom-add").click(function(){
//		
//		
//		$.post("keFuAction_addCustom",{
//						   						custom.customIdCard:"3523",
//						   						custom.customName:"3523",
//						   						custom.customCompany:"3523",
//						   						custom.customTel:"3523",
//						   						custom.customMabile:"3523",
//						   						custom.customAddrass:"3523",
//						   						custom.customEmail:"3523",
//						   						custom.customPost:"3523",
//						   					},function(data,status){
//						    alert("Data: " + data + "nStatus: " + status);
//					  });
//	});
//})
//

//$(function(){
//  $('.add-custom-add').click(function(){
//       $.ajax({
//           type: "GET",
//           url: "<%=basePath%>keFuAction_addCustom",
//           data: {custom.customIdCard:$("#customIdCard").val(),
//						   						custom.customName:$("#customName").val(),
//						   						custom.customCompany:$("#customCompany").val(),
//						   						custom.customTel:$("#customTel").val(),
//						   						custom.customMabile:$("#customMabile").val(),
//					   						custom.customAddrass:$("#customAddrass").val(),
//						   						custom.customEmail:$("#customEmail").val(),
//						   						custom.customPost:$("#customPost").val()
//						   						},
//           dataType: "json",
//           success: function(data){
//                       $('.add-success').empty();   //清空resText里面的所有内容
//                       var html = '<h6>'+data.info+'</h6>'; 
//                      
//                       $('.add-success').html(html);
//                    }
//       });
//  });
//});



