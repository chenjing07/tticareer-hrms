Ext.define('Admin.view.laborContractapprove.LaborContractApproveWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.laborContractApproveWindow',

    height: 300,
    minHeight: 10,
    minWidth: 300,
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
        ariaLabel: 'Add LaborContract Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '工号',
            name:'employerName',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '员工Id',
            name:'employeeId',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '合同期限',
            name:'contractTimeLimit',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '生效日期',
            name:'contractStart',
			format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '终止日期',
            name:'contractEnd',
			format: 'Y/m/d H:i:s',
			readOnly: true
        },
        {
            xtype: 'datefield',
            fieldLabel: '工作内容',
            name:'workContent',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '工作地点',
            name:'workPlace',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '劳动保护',
            name:'laborProtection',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '劳动条件',
            name:'laborConditions',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '劳动报酬',
            name:'laborReward',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '违约责任',
            name:'defaultResponsibility',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '社会保险',
            name:'socialInsurance',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '合同变更',
            name:'contractChange',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '创建日期',
            name:'createTime',
			format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
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
        }, {
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

