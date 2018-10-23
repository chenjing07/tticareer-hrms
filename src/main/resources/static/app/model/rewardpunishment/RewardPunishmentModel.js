Ext.define('Admin.model.rewardpunishment.RewardPunishmentModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
    	{type: 'int',name: 'id'},
    	{type:'int',name:'employeeId'},
    	{type:'string',name:'userName'},
    	{type:'string',name:'realName'},
    	{type: 'string', name: 'rewardAndPunishment'},
    	{type: 'string', name: 'content'},
		{type: 'date',name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'state'},
        {type: 'string', name: 'checkSatus'},
    	{type: 'string',name: 'note'}
    ],
    	proxy: {
		type: 'rest',
		url: '/rewardpunishment/save'
	}
});