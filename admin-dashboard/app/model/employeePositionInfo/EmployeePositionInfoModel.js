Ext.define('Admin.model.employeePositionInfo.EmployeePositionInfoModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'employeeId'},
		{type: 'int', name: 'positionId'},
		{type: 'date',name: 'arrivePost',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'leavePost',dateFormat:'Y/m/d H:i:s'},
		{type: 'string', name: 'transferReason'},
		{type: 'string',name: 'leaveOpinion'},
		{type: 'string',name: 'arriveOpinion'},
		{type: 'int', name: 'state'},
		{type: 'date',name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'int',name: 'checkStatus'},
	    {type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/employeePositionInfo/save'
	}
});
