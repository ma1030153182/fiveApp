//根据json创建树
function showJSON() {  
$(function(){

//  var tree = null;var root = new TreeNode('系统菜单');
//var fun1 = new TreeNode('组织机构管理');
//var fun2 = new TreeNode('部门管理', '..//right/zuzhijigouguanli/bumen/chaxunbumen.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
//fun1.add(fun2);
//var fun3 = new TreeNode('岗位管理', '..//right/zuzhijigouguanli/gangwei/chaxungangwei.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
//fun1.add(fun3);
////var fun4 = new TreeNode('员工管理', 'EmployeeMgr.aspx', 'tree_node.gif', null, 'tree_node.gif', null);
////fun1.add(fun4);
//root.add(fun1);
//tree = new Tree(root);tree.show('menuTree')
//
      $.ajax({

             type: "GET",
           url: "loginAction_checkRole",
            dataType: "json",

             success: function(data){
             
             var tree = null;
             var root=null;
                       var l = data.role.length;
	                console.log(l);     
		for(var i=0;i< l;i++){ 
			if(data.role[i].parentId == "0"){
			console.log(data.role[i].parentId); 
			 root = new TreeNode(data.role[i].moduleName,null,'tree_node.gif','tree_node.gif','tree_node.gif','tree_node.gif',null);
//				document.write(data.role[i].moduleName + "<br>");		
				for(var j=0; j < l ;j++){
					if(data.role[j].parentId == data.role[i].moduleId){
					var fun1 = new TreeNode(data.role[j].moduleName,data.role[j].moduleUrl,null,null,null,null,data.role[j].moduleId);
					root.add(fun1);
//					document.write("　");
//					document.write(data.role[j].moduleName + "<br>");
					}
				}
			} 
		}
 tree = new Tree(root);tree.show('menuTree');
 
 
 
                      }

  

    });

});

}



//function showJSON() {    
//  var user =    
//   {    
//		 "cate" :  [{"cid" : "1","name" : "品牌1","pid" : "0"},
//			{"cid" : "2","name" : "品牌2","pid" : "0"},
//			{"cid" : "3","name" : "品牌3","pid" : "1"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "0"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "4"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "4"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "4"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "4","name" : "品牌4","pid" : "2"},
//			{"cid" : "5","name" : "品牌5","pid" : "1"}
//			]
//   }    
//    var l = user.cate.length;
//	  
//		for(var i=0;i < l;i++){ 
//			if(user.cate[i].pid == "0"){
//				document.write(user.cate[i].name + "<br>");		
//				for(var j=0; j < l ;j++){
//					if(user.cate[j].pid == user.cate[i].cid){
//					document.write("　");
//					document.write(user.cate[j].name + "<br>");
//					}
//				}
//			} 
//		}
//}    
