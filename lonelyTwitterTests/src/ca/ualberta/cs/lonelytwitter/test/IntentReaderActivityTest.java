package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {
	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		assertEquals("some string", activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		assertEquals("some string some string ", activity.getText());
	}
	
	public void testReverseText() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		assertEquals(" gnirts emos", activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		assertEquals("some string some string ", activity.getView().getText());
	}
	
	public void testDefaultText() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		assertEquals("Default message", activity.getView().getText());
	}
	
	public void testTextVisible() {
		Intent intent=new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);
		setActivityIntent(intent);
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		View onWindow=activity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(onWindow, activity.getView());
	}
	
	public void testDisplayText2() throws Throwable {
		IntentReaderActivity activity=(IntentReaderActivity) getActivity();
		
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getActivity().getView().setText("some string some string ");
			}
		});
		
		assertEquals("some string some string ", activity.getView().getText());
	}
}
