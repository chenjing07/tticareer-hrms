
Ext.define('Admin.view.department.DepartmentPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'Department Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{departmentLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'superiorDepartmentId',text: '上级部门ID',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentNumber',text: '部门编号',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentName',text: '部门名称',flex:1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
                    ]
                }
            ],
            tbar: [		{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
								fields: ["name", "value"],
								data: [
									{ name: '部门编号', value: 'departmentNumber' },
									{ name: '部门名称', value: 'departmentName' }
								]
							}),     
		                    displayField: 'name',
		                    valueField:'value',
							value:'departmentNumber',
							editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
								select: 'searchComboboxSelectChuang'
							}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchFieldValue',
							name:'departmentPanelSearchField'
		                } ,'-', {
		                    xtype:'datefield',            
							reference:'searchFieldValue1',
							hidden :true,
							name:'departmentPanelSearchField1'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
						},'-',{
							text: 'Search More',
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
							itemId:'departmentGridPanelRemove', 
							disabled: true,
							handler: 'deleteMoreRows'	     			 
						}
				],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{departmentLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#departmentGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
