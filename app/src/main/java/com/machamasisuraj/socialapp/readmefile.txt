@Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override    protected void onResume() {

        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();

    }



mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                inputEmail.setText("");
                inputPhone .setText("");
                inputAddress.setText("");
                inputFullname .setText("");
                inputPassword .setText("");
            }
        });



static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
