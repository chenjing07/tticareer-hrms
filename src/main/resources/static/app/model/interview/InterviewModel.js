Ext.define('Admin.model.interview.InterviewModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'resumeId'},
		{type: 'string', name: 'oneContent'},
		{type: 'date', name: 'oneStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'date', name: 'oneEnd',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'oneFeedback'},
		{type: 'string', name: 'twoContent'},
		{type: 'date', name: 'twoStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'date', name: 'twoEnd',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'twoFeedback'},
		{type: 'int',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/interview/save'
	}
});
