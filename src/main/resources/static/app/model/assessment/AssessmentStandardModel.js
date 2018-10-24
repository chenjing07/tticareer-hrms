Ext.define('Admin.model.assessment.AssessmentStandardModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'positionId'},
	    {type: 'string',name: 'positionNumber'},
	    {type: 'string',name: 'positionName'},
	    {type: 'string',name: 'workResult'},
	    {type: 'string',name: 'attitude'},
	    {type: 'string',name: 'quality'},
	    {type: 'string',name: 'skill'},
	    {type: 'string',name: 'calculationWay'},
	    {type: 'string',name: 'assessmentType'},
	    {type: 'string',name: 'resultLevel'},
	    {type: 'string',name: 'checkStatus'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/assessment/assave',
	}
});