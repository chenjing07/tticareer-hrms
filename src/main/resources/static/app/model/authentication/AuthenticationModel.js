Ext.define('Admin.model.authentication.AuthenticationModel', {
    extend: 'Admin.model.Base',
    fields: [
    	       {type: 'int',name: 'id'},
		{type: 'string',name: 'userName'},
		{type: 'string', name: 'password'},
		{type: 'string',name: 'realName'},
		{type: 'string',name: 'idCardNumber'},
		{type: 'string', name: 'idCardPicture'},
		{type: 'int',name: 'state'},
             {type: 'int', name: 'checkSatus'},
    		{type: 'string',name: 'note'}
    ],
    	proxy: {
		type: 'rest',
		url: '/employee/save'
	}
});