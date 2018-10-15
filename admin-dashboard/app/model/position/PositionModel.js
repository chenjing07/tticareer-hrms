Ext.define('Admin.model.position.PositionModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'departmentId'},
		{type: 'string', name: 'positionNumber'},
		{type: 'string',name: 'positionName'},
		{type: 'int',name: 'superiorPositionid'},
		{type: 'string',name: 'positionIntroduction'},
		{type: 'int',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
             {type: 'int', name: 'checkStatus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/position/save'
	}
});
