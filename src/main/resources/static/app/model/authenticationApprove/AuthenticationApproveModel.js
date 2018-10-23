Ext.define('Admin.model.authenticationApprove.AuthenticationApproveModel', {
    extend: 'Admin.model.Base',
    fields: [	//需要修改
		 {type: 'int' ,name: 'id'}
           	,{type: 'string' ,name: 'userName'}
		,{type: 'string' ,name: 'realName'}
		,{type: 'string',name: 'idCardNumber'}
       	 ,{type: 'string',name: 'idCardPicture'}
       	 ,{type: 'date',name: 'applyTime',dateFormat:'Y/m/d H:i:s'}
        ,{type: 'string' ,name: 'leaveType'}
        ,{type: 'string' ,name: 'processStatus'}
		,{type: 'string' ,name: 'reason'}
        ,{type: 'string' ,name: 'processInstanceId'}
        ,{type: 'string' ,name: 'taskId'}
        ,{type: 'string' ,name: 'taskName'}
        ,{type: 'date' ,name: 'taskCreateTime'}
        ,{type: 'string' ,name: 'assignee'}
        ,{type: 'string' ,name: 'taskDefinitionKey'}
        ,{type: 'string' ,name: 'processDefinitionId'}
        ,{type: 'boolean' ,name: 'suspended'}
        ,{type: 'int' ,name: 'version'}
    ]
});