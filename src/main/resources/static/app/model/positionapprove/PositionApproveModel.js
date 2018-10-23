Ext.define('Admin.model.positionapprove.PositionApproveModel', {
extend: 'Admin.model.Base',
	
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
	]
});
