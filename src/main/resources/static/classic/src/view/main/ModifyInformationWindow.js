Ext.define('Admin.view.authentication.ModifyInformationWindow', {
    extend: 'Ext.window.Window',
    xtype: 'modifyInformationWindow',

    requires: [
        'Admin.view.authentication.Dialog',
        'Ext.button.Button',
        'Ext.form.field.ComboBox',
        'Ext.form.Label',
        'Ext.form.field.Checkbox',
        'Ext.form.field.Text'
    ],

    height: 300,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    closable: true,
    constrain: true,
    title: 'Modify Information Window',
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
          xtype:'form',
          layout: 'form',
          padding: '10px',
          ariaLabel: 'Modify Your Information',
          items: [
              {
	                xtype: 'textfield',
	                fieldLabel: 'User Name',
	                allowBlank : false,
	                name:'userName',
	                hidden: true,
	                readOnly: true
              },
              {
                      xtype: 'textfield',
                      fieldLabel: 'Real Name',
                      allowBlank : false,
            	   name:'realName'
              },
              {
                    xtype: 'textfield',
                    fieldLabel: 'id Card Number',
                    allowBlank : false,
                    name:'idCardNumber'
              },
              {
                   xtype: 'filefield',
                   fieldLabel:'id Card Picture',
                   allowBlank : false,
                   name:'idCardPicture',
                   buttonConfig: {
		            xtype: 'filebutton',
		            glyph:'',
		            text: 'Browse'
	             }
              }, 
              {
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
              }]
         }],
		buttons:['->',{
			xtype: 'button',
			text: 'submit',
			handler: 'modifyInformationSubmitButton'
		},{
			xtype: 'button',
			text: 'Close',
			handler: function(btn) {
				btn.up('window').close();
			}
		},'->']
});
