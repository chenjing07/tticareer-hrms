Ext.define('Admin.model.recruitmentDemand.RecruitmentDemandModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'positionId'},
		{type: 'int', name: 'planNumber'},
		{type: 'string',name: 'salary'},
		{type: 'int',name: 'supplementalNumber'},
		{type: 'string', name: 'supplementReason'},
		{type: 'date',name: 'arrivalDate',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'languageRequirements'},
		{type: 'string', name: 'professionalRequirements'},
		{type: 'string',name: 'educationalRequirements'},
		{type: 'string',name: 'computerRequirements'},
		{type: 'string', name: 'experienceRequirements'},
		{type: 'string',name: 'ageRequirements'},
		{type: 'string',name: 'postDuties'},
		{type: 'string', name: 'postRequirements'},
		{type: 'string',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/recruitmentDemand/save'
	}
});
