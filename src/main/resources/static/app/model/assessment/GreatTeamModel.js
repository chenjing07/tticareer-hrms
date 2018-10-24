Ext.define('Admin.model.assessment.GreatTeamModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'departmentId'},
	    {type: 'string',name: 'departmentNumber'},
	    {type: 'string',name: 'departmentName'},
	    {type: 'string',name: 'commend'},
	    {type: 'string',name: 'reward'},
	    {type: 'string',name: 'checkStatus'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/assessment/gtsave',
	}
});