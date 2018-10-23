Ext.define('Admin.model.department.DepartmentModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'superiorDepartmentId'},
		{type: 'string', name: 'departmentNumber'},
		{type: 'string',name: 'departmentName'},
		{type: 'string',name: 'departmentIntroduction'},
		{type: 'int',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
             {type: 'int', name: 'checkStatus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/department/save'
	}
});
