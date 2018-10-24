Ext.define('Admin.model.training.TrainingFeedbackModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'trainingInfoId'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'userName'},
	    {type: 'string',name: 'realName'},
	    {type: 'string',name: 'lecturer'},
	    {type: 'date', name: 'time', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'duration'},
	    {type: 'string',name: 'purpose'},
	    {type: 'string',name: 'place'},
	    {type: 'string',name: 'content'},
	    {type: 'string',name: 'trainingFeedback'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/training/tfsave',
	}
});