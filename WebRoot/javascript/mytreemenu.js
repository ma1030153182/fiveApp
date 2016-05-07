$(function() {

	// 实例化树形菜单

	$("#tree").tree({

		// data : treeData,

		// lines : true,

		url : "loginAction_checkRole",

		loadFilter : function(rows) {

			return convert(rows);
		},

		onClick : function(node) {

		

			if (node.attributes && node.attributes.parentId != 0) {

				Open(node.text, node.attributes.url);

			}

		}

	});

	// 在右边center区域打开菜单，新增tab

	function Open(text, url) {
		

		if ($("#tabs").tabs('exists', text)) {

			$('#tabs').tabs('select', text);

		} else {

			$('#tabs').tabs('add', {
				width : 800,

				title : text,

				closable : true,

				href : url

			});

		}

	}
	// 转换
	function convert(rows) {
		function exists(rows, parentId) {
			for (var i = 0; i < rows.length; i++) {
				if (rows[i].id == parentId)
					return true;
			}
			return false;
		}

		var nodes = [];
		// get the top level nodes
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (!exists(rows, row.parentId)) {
				nodes.push({
					id : row.id,
					text : row.name,
					attributes : {
						url : row.url,
						parentId : row.parentId
					}
				});
			}
		}

		var toDo = [];
		for (var i = 0; i < nodes.length; i++) {
			toDo.push(nodes[i]);
		}
		while (toDo.length) {
			var node = toDo.shift(); // the parent node
			// get the children nodes
			for (var i = 0; i < rows.length; i++) {
				var row = rows[i];
				if (row.parentId == node.id) {
					var child = {
						id : row.id,
						text : row.name,
						attributes : {
							url : row.url,
							parentId : row.parentId
						}
					};
					if (node.children) {
						node.children.push(child);
					} else {
						node.children = [ child ];
					}
					toDo.push(child);
				}
			}
		}
		return nodes;
	}

});
