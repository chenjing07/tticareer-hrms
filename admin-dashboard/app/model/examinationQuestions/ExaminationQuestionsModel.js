Ext.define('Admin.model.examinationQuestions.ExaminationQuestionsModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'string',name: 'question'},
		{type: 'string', name: 'answer'},
		{type: 'string',name: 'score'},
		{type: 'string',name: 'difficultyLevel'},
		{type: 'string',name: 'category'},
		{type: 'string',name: 'explanation'},
		{type: 'string',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/examinationQuestions'
	}
});
