@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.some_layout);
			//This will introduce the little caret on the application icon to indicate "Up Navigation"
			getActionBar().setDisplayHomeAsUpEnabled(true);
			...
						
		}
		
		/*
		  The handling of the caret click event
		  This is when the user clicks on the up-navigation
		*/
		public boolean onOptionsItemSelected(MenuItem item) {
			// which action-item was selected
			switch(item.getItemId()){
			case android.R.id.home:
				Intent upIntent = NavUtils.getParentActivityIntent(this);
				if(NavUtils.shouldUpRecreateTask(this, upIntent)){					
					TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
				}
				else{								
					NavUtils.navigateUpTo(this, upIntent);
				}
			}
			
			return true;
		}	
