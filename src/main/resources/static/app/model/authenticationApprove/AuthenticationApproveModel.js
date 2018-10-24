Ext.define('Admin.model.authenticationApprove.AuthenticationApproveModel', {
    extend: 'Admin.model.Base',
    fields: [	//需要修改
		 {type: 'int' ,name: 'id'}
           	,{type: 'string' ,name: 'userName'}
		,{type: 'string' ,name: 'realName'}
		,{type: 'string',name: 'idCardNumber'}
       	 ,{type: 'string',name: 'idCardPicture'}
       	 ,{type: 'date',name: 'applyTime',dateFormat:'Y/m/d H:i:s'}
		//,{type: 'int' ,name: 'checkStatus'}
		,{type: 'date',name: 'createTime',dateFormat:'Y/m/d H:i:s'}
    ]
});