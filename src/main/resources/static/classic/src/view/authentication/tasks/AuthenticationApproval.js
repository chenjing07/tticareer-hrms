Ext.define('Admin.view.authentication.tasks.AuthenticationApproval', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.authenticationApproval',
    requires: [
        'Ext.button.Button',
        'Ext.form.RadioGroup',
        'Ext.form.field.*'
 
    ],
    bodyPadding: 10,
    bodyBorder: true,
    defaults: {
        anchor: '100%'
    },
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'none',
        invalidCls: '' 
    },
    items: [{
    	xtype: 'textfield',
		name: 'taskId',
		fieldLabel: '任务ID',
        hidden: true,
        readOnly: true
	},{
		xtype: 'radiogroup',
		fieldLabel: '经理审批',
		defaults: {
			flex: 1
		},
		items: [{
			name: 'managerPass',
			reference:'managerPassTrue',
			inputValue: true,
			boxLabel: '同意',
			checked: true,
			listeners:{
					select: 'managerBackReasonTrueOrFalse'
			}
		}, {
			name: 'managerPass',
			reference:'managerPassFalse',
			inputValue: false,
			boxLabel: '不同意',
			listeners:{
					select: 'managerBackReasonTrueOrFalse'
			}
		}]
    },{
    	  reference:'managerBackReason',
        xtype     : 'textareafield',
        grow      : true,
        name      : 'managerBackReason',//修改
        fieldLabel: '驳回理由',
        anchor    : '100%'
    }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'authenticationApprovalSubmitButton'
	},{
		xtype: 'button',
		ui: 'gray',
		text: '取消',
		handler:function(btn){
			var win = btn.up('window');
	        if (win) {
	            win.close();
	        }
		}
	}]
});
