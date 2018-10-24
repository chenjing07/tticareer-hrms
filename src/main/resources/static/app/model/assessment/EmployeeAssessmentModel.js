Ext.define('Admin.model.assessment.EmployeeAssessmentModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'userName'},
	    {type: 'string',name: 'realName'},
	    {type: 'string',name: 'assessmentType'},
	    {type: 'string',name: 'workResult'},
	    {type: 'string',name: 'attitude'},
	    {type: 'string',name: 'quality'},
	    {type: 'string',name: 'skill'},
	    {type: 'string',name: 'assessmentResult'},
	    {type: 'string',name: 'evaluate'},
	    {type: 'string',name: 'checkStatus'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/assessment/easave',
	}
});