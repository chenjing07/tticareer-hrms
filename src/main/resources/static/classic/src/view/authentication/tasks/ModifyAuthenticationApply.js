Ext.define('Admin.view.authentication.tasks.ModifyAuthenticationApply', {
    extend: 'Ext.form.Panel',
    alias: 'widget.modifyAuthenticationApply',
    requires: [
        'Ext.button.Button',
        'Ext.form.RadioGroup',
        'Ext.form.field.*'
    ],
    bodyPadding: 5,
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
		xtype: 'radiogroup',
		fieldLabel: '重新申请',
		items: [{
			name: 'reApply',
			inputValue: true,
			boxLabel: '是',
			checked: true
		}, {
			name: 'reApply',
			inputValue: false,
			boxLabel: '否'
		}]
    },{
    	  xtype: 'textfield',
	  name: 'taskId',
 	  fieldLabel: '任务ID',
        hidden: true,
        readOnly: true
	},{
                  xtype: 'textfield',
                  fieldLabel: 'Real Name',
                  allowBlank : false,
        	   name:'real_name'
          },{
                xtype: 'textfield',
                fieldLabel: 'id Card Number',
                allowBlank : false,
                name:'idCardNumber'
          },{
               xtype: 'filefield',
               fieldLabel:'id Card Picture',
               allowBlank : false,
               name:'idCardPicture',
               buttonConfig: {
	            xtype: 'filebutton',
	            glyph:'',
	            text: 'Browse'
             }
          },{
                xtype: 'combobox',
                reference:'selectFieldName',
                fieldLabel: 'Permission',
                allowBlank : false,
                name: 'state',    
                store:Ext.create("Ext.data.Store", {
			    fields: ["name", "value"],
			    data: [
			      	{ name: '人事部普通员工', value: '3' },
					{ name: '人事部经理', value: '4' }
			    ]
			}),
              displayField: 'name',
              valueField:'value',
              selectOnFocus:false,
              editable: false,
              queryMode: 'local'
          }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交',
		handler: 'modifyAuthenticationlApplySubmitButton'
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
