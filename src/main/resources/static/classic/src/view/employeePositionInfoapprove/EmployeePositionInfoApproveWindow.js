Ext.define('Admin.view.employeePositionInfoapprove.EmployeePositionInfoApproveWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeePositionInfoApproveWindow',

    y:10,
    height: 400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '审批窗口',
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
        },  {
            xtype: 'textfield',
            fieldLabel: '员工Id',
            name:'employeeId',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '岗位id',
            name:'positionId',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '到岗时间',
            name:'arrivePost',
			format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '调岗时间',
            name:'leavePost',
			format: 'Y/m/d H:i:s',
			readOnly: true
        },
        {
            xtype: 'datefield',
            fieldLabel: '调岗原因',
            name:'transferReason',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '调出部门意见',
            name:'leaveOpinion',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '调入部门意见',
            name:'arriveOpinion',
			readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '创建日期',
            name:'createTime',
			format: 'Y/m/d H:i:s',
			readOnly: true
        },/* {
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '审查状态',
            name:'checkStatus',
			readOnly: true
        },*/ {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note',
			readOnly: true
        }]
    }],
    buttons:  ['->',{
        xtype: 'button',
        text: 'Pass',
        handler: 'passApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'NoPass',
        handler: 'nopassApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});

