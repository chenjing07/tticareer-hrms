Ext.define('Admin.view.employeePositionInfo.EmployeePositionInfoAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeePositionInfoAddWindow',

	
    y:10,
    height:400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '增添调动信息',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add EmployeePositionInfo Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'combo',
            fieldLabel: '<span style="color:red;">*</span>员工id',
            name:'employeeId',
			store : Ext.create('Ext.data.Store',{
				fields:[
					{type:'int',name:'employeeId'},
					{type:'string',name:'employeeName'}
				],
				 proxy: {
					type: 'rest',
					url: '/employee/getEmployeeIdAndName',	//mvc url  xxx.json
					reader:{
						type:'json',
						rootProperty:'data',
						totalProperty: 'totalElements'
					},
						writer: {
						type: 'json'
					},
						simpleSortMode: true
				},
				autoLoad:true,
				autoSync:true
			}),
			mode : 'local',
			allowBlank : false,
			editable : false, 
			valueField : 'employeeId',
			displayField : 'employeeName'
        }, {
            xtype: 'combo',
            fieldLabel: '<span style="color:red;">*</span>岗位id',
            name:'positionId',
			store : Ext.create('Ext.data.Store',{
				fields:[
					{type:'int',name:'positionId'},
					{type:'string',name:'positionName'}
				],
				 proxy: {
					type: 'rest',
					url: '/position/getPositionIdAndName',	//mvc url  xxx.json
					reader:{
						type:'json',
						rootProperty:'data',
						totalProperty: 'totalElements'
					},
						writer: {
						type: 'json'
					},
						simpleSortMode: true
				},
				autoLoad:true,
				autoSync:true
			}),
			mode : 'local',
			allowBlank : false,
			editable : false, 
			valueField : 'positionId',
			displayField : 'positionName'
        },
        {
            xtype: 'datefield',
            fieldLabel: '<span style="color:red;">*</span>到岗时间',
            name:'arrivePost',
			format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '调岗时间',
            name:'leavePost',
			format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '调岗原因',
            name:'transferReason'
        }, {
            xtype: 'textfield',
            fieldLabel: '调出部门意见',
            name:'leaveOpinion'
        }, {
            xtype: 'textfield',
            fieldLabel: '调入部门意见',
            name:'arriveOpinion'
        },
        /*{
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state'
        }, */{
            xtype: 'datefield',
            fieldLabel: '<span style="color:red;">*</span>录入时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, /*{
            xtype: 'textfield',
            fieldLabel: '审核状态',
            name:'checkStatus'
        },*/ {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
