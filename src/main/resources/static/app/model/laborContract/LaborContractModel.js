Ext.define('Admin.model.laborContract.LaborContractModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'string',name: 'employerName'},
		{type: 'int', name: 'employeeId'},
		{type: 'int',name: 'contractTimeLimit'},
		{type: 'date',name: 'contractStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'contractEnd',dateFormat:'Y/m/d H:i:s'},
		{type: 'string', name: 'workContent'},
		{type: 'string',name: 'workPlace'},
		{type: 'string',name: 'laborProtection'},
		{type: 'string', name: 'laborConditions'},
		{type: 'string',name: 'laborReward'},
		{type: 'string',name: 'defaultResponsibility'},
		{type: 'string', name: 'socialInsurance'},
		{type: 'string',name: 'contractChange'},
		{type: 'int',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
             {type: 'int', name: 'checkStatus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/laborContract/save'
	}
});
