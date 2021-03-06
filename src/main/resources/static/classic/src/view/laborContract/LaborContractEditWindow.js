Ext.define('Admin.view.laborContract.LaborContractEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.laborContractEditWindow',

    y:10,
    height:400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改劳动合同信息',
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
            fieldLabel: '甲方名称',
            name:'employerName'
        }, {
            xtype: 'combo',
            fieldLabel: '员工Id',
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
        },
        {
            xtype: 'textfield',
            fieldLabel: '合同期限',
            name:'contractTimeLimit'
        }, {
            xtype: 'datefield',
            fieldLabel: '开始时间',
            name:'contractStart',
            format: 'Y/m/d H:i:s'
        },  {
            xtype: 'datefield',
            fieldLabel: '终止时间',
            name:'contractEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '工作内容',
            name:'workContent'
        }, {
            xtype: 'textfield',
            fieldLabel: '工作地点',
            name:'workPlace'
        },
        {
            xtype: 'textfield',
            fieldLabel: '劳动保护',
            name:'laborProtection'
        }, {
            xtype: 'textfield',
            fieldLabel: '劳动条件',
            name:'laborConditions'
        }, {
            xtype: 'textfield',
            fieldLabel: '劳动报酬',
            name:'laborReward'
        },
        {
            xtype: 'textfield',
            fieldLabel: '违约责任',
            name:'defaultResponsibility'
        }, {
            xtype: 'textfield',
            fieldLabel: '社会保险',
            name:'socialInsurance'
        }, {
            xtype: 'textfield',
            fieldLabel: '合同变更',
            name:'contractChange'
        },/*{
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state'
        }, */{
            xtype: 'datefield',
            fieldLabel: '创建时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        },/* {
            xtype: 'textfield',
            fieldLabel: '审查状态',
            name:'checkStatus'
        },*/ {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'editSubmitButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
