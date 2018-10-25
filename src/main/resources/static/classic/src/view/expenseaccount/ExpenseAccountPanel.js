Ext.define('Admin.view.expenseaccount.ExpenseAccountPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'expenseAccountPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],

    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'expenseaccount-grid',
            title: '报销信息',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{expenseAccountLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'employeeId',text: 'employee Id',flex:1,hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: '员工编号',flex:2},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: '员工名字',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'amount',text: '报销金额',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'reason',text: '报销原因',flex:1},
       	{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'content',text: '报销说明',flex:2},
           {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
           {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'time',text: '报销时间',renderer:Ext.util.Format.dateRenderer('Y/m/d')},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'statement',text: '状态',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkStatusment',text: '审查状态',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: 'Note',flex:1},
		   
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-check',handler: 'openCheckWindow'}
                    ]
                }
            ],
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '工号', value: 'employee_number' },
								{ name: '报销日期', value: 'time' },
								{ name: '未审核', value: 'check_status' },
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           			 value:'employee_number',
	           			 editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
						select: 'searchComboboxSelectChuang'
				}
		            },'-',{
		                xtype:'textfield',
		                reference:'searchNumberFieldValue',
            			name:'SearchNumberField'
		            },'-',{
		                xtype:'datefield',            
            			reference:'searchDateStartFieldValue',
            		 	hidden :true,
            			name:'SearchDateStartField',
            			format: 'Y/m/d H:i:s'
		            },'-',{
		                xtype:'datefield',            
	            	    reference:'searchDateEndFieldValue',
	            		hidden :true,
	            	    name:'SearchDateEndField',
	            		format: 'Y/m/d H:i:s'
			        },'-',{
				        text: '快捷查询',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: '复杂查询',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'expenseAccountPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{expenseAccountLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#expenseAccountPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
