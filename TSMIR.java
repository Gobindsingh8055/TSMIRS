import React, { useState, useEffect } from 'react';
import { MapPin, Shield, AlertTriangle, CheckCircle, Users, Activity, Bell, Lock, Radio } from 'lucide-react';

const TouristSafetySystem = () => {
  const [activeTab, setActiveTab] = useState('dashboard');
  const [tourists, setTourists] = useState([]);
  const [incidents, setIncidents] = useState([]);
  const [alerts, setAlerts] = useState([]);
  const [safeZones, setSafeZones] = useState([
    { id: 1, name: 'Tourist District', lat: 28.6139, lng: 77.2090, radius: 2, status: 'safe' },
    { id: 2, name: 'Heritage Zone', lat: 28.6562, lng: 77.2410, radius: 1.5, status: 'safe' },
    { id: 3, name: 'Market Area', lat: 28.6289, lng: 77.2065, radius: 1, status: 'caution' }
  ]);

  useEffect(() => {
    // Initialize with sample data
    setTourists([
      { id: 'T001', name: 'John Smith', country: 'USA', location: { lat: 28.6139, lng: 77.2090 }, status: 'safe', blockchainId: '0x7a9f...3c2e' },
      { id: 'T002', name: 'Maria Garcia', country: 'Spain', location: { lat: 28.6562, lng: 77.2410 }, status: 'safe', blockchainId: '0x4b1c...8d9a' },
      { id: 'T003', name: 'Li Wei', country: 'China', location: { lat: 28.6289, lng: 77.2065 }, status: 'alert', blockchainId: '0x9e2f...1a4b' }
    ]);

    setIncidents([
      { id: 'INC001', type: 'Medical', severity: 'medium', location: 'Market Area', time: '10 min ago', status: 'responding' },
      { id: 'INC002', type: 'Theft Report', severity: 'low', location: 'Tourist District', time: '1 hr ago', status: 'resolved' }
    ]);

    setAlerts([
      { id: 'A001', message: 'Tourist T003 entered restricted zone', severity: 'warning', time: '5 min ago' },
      { id: 'A002', message: 'Crowding detected in Heritage Zone', severity: 'info', time: '15 min ago' }
    ]);
  }, []);

  const DashboardView = () => (
    <div className="space-y-6">
      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <StatCard icon={<Users />} label="Active Tourists" value={tourists.length} color="blue" />
        <StatCard icon={<Shield />} label="Safe" value={tourists.filter(t => t.status === 'safe').length} color="green" />
        <StatCard icon={<AlertTriangle />} label="Alerts" value={tourists.filter(t => t.status === 'alert').length} color="yellow" />
        <StatCard icon={<Activity />} label="Active Incidents" value={incidents.filter(i => i.status === 'responding').length} color="red" />
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold mb-4 flex items-center gap-2">
            <MapPin className="w-5 h-5" />
            Live Tourist Tracking
          </h3>
          <div className="space-y-3">
            {tourists.map(tourist => (
              <div key={tourist.id} className="flex items-center justify-between p-3 bg-gray-50 rounded-lg">
                <div>
                  <p className="font-medium">{tourist.name}</p>
                  <p className="text-sm text-gray-600">{tourist.country} • ID: {tourist.id}</p>
                  <p className="text-xs text-gray-500 mt-1">Blockchain: {tourist.blockchainId}</p>
                </div>
                <span className={`px-3 py-1 rounded-full text-sm ${
                  tourist.status === 'safe' ? 'bg-green-100 text-green-700' : 'bg-yellow-100 text-yellow-700'
                }`}>
                  {tourist.status}
                </span>
              </div>
            ))}
          </div>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold mb-4 flex items-center gap-2">
            <Bell className="w-5 h-5" />
            Recent Alerts
          </h3>
          <div className="space-y-3">
            {alerts.map(alert => (
              <div key={alert.id} className="p-3 border-l-4 bg-gray-50 rounded" style={{
                borderColor: alert.severity === 'warning' ? '#f59e0b' : '#3b82f6'
              }}>
                <p className="text-sm font-medium">{alert.message}</p>
                <p className="text-xs text-gray-500 mt-1">{alert.time}</p>
              </div>
            ))}
          </div>
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4 flex items-center gap-2">
          <Activity className="w-5 h-5" />
          Active Incidents
        </h3>
        <div className="space-y-3">
          {incidents.map(incident => (
            <div key={incident.id} className="flex items-center justify-between p-4 bg-gray-50 rounded-lg">
              <div>
                <p className="font-medium">{incident.type}</p>
                <p className="text-sm text-gray-600">{incident.location} • {incident.time}</p>
              </div>
              <div className="flex gap-3 items-center">
                <span className={`px-3 py-1 rounded-full text-sm ${
                  incident.severity === 'high' ? 'bg-red-100 text-red-700' :
                  incident.severity === 'medium' ? 'bg-yellow-100 text-yellow-700' :
                  'bg-blue-100 text-blue-700'
                }`}>
                  {incident.severity}
                </span>
                <span className={`px-3 py-1 rounded-full text-sm ${
                  incident.status === 'responding' ? 'bg-orange-100 text-orange-700' :
                  'bg-green-100 text-green-700'
                }`}>
                  {incident.status}
                </span>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );

  const GeoFencingView = () => (
    <div className="space-y-6">
      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4">Geo-Fenced Safety Zones</h3>
        <div className="space-y-4">
          {safeZones.map(zone => (
            <div key={zone.id} className="p-4 border rounded-lg">
              <div className="flex justify-between items-start mb-3">
                <div>
                  <h4 className="font-medium">{zone.name}</h4>
                  <p className="text-sm text-gray-600">Radius: {zone.radius} km</p>
                  <p className="text-xs text-gray-500 mt-1">
                    Coordinates: {zone.lat.toFixed(4)}, {zone.lng.toFixed(4)}
                  </p>
                </div>
                <span className={`px-3 py-1 rounded-full text-sm ${
                  zone.status === 'safe' ? 'bg-green-100 text-green-700' : 'bg-yellow-100 text-yellow-700'
                }`}>
                  {zone.status}
                </span>
              </div>
              <div className="flex gap-2">
                <button className="px-4 py-2 bg-blue-600 text-white text-sm rounded hover:bg-blue-700">
                  View on Map
                </button>
                <button className="px-4 py-2 bg-gray-200 text-gray-700 text-sm rounded hover:bg-gray-300">
                  Edit Zone
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4">Zone Breach Detection</h3>
        <div className="p-4 bg-blue-50 rounded-lg border border-blue-200">
          <div className="flex items-start gap-3">
            <Radio className="w-5 h-5 text-blue-600 mt-1" />
            <div>
              <p className="font-medium text-blue-900">AI-Powered Monitoring Active</p>
              <p className="text-sm text-blue-700 mt-1">
                System continuously monitors tourist locations and triggers alerts when they enter restricted zones or leave safe perimeters.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );

  const BlockchainView = () => (
    <div className="space-y-6">
      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4 flex items-center gap-2">
          <Lock className="w-5 h-5" />
          Blockchain-Based Digital Identity
        </h3>
        <div className="space-y-4">
          {tourists.map(tourist => (
            <div key={tourist.id} className="p-4 border rounded-lg bg-gradient-to-r from-purple-50 to-blue-50">
              <div className="flex items-start justify-between mb-3">
                <div>
                  <h4 className="font-medium">{tourist.name}</h4>
                  <p className="text-sm text-gray-600">{tourist.country}</p>
                </div>
                <CheckCircle className="w-5 h-5 text-green-600" />
              </div>
              <div className="space-y-2 text-sm">
                <div className="flex justify-between">
                  <span className="text-gray-600">Tourist ID:</span>
                  <span className="font-mono">{tourist.id}</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Blockchain Address:</span>
                  <span className="font-mono text-xs">{tourist.blockchainId}</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Verification Status:</span>
                  <span className="text-green-600 font-medium">Verified ✓</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Last Transaction:</span>
                  <span className="text-gray-700">2 hours ago</span>
                </div>
              </div>
              <button className="mt-3 w-full px-4 py-2 bg-purple-600 text-white text-sm rounded hover:bg-purple-700">
                View Full Blockchain Record
              </button>
            </div>
          ))}
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4">Blockchain Features</h3>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <FeatureCard 
            title="Immutable Records"
            description="All tourist movements and incidents are recorded on blockchain for tamper-proof audit trails"
          />
          <FeatureCard 
            title="Privacy Protection"
            description="Personal data encrypted with zero-knowledge proofs, only accessible with proper authorization"
          />
          <FeatureCard 
            title="Smart Contracts"
            description="Automated incident response protocols triggered by predefined conditions"
          />
          <FeatureCard 
            title="Cross-Border Verification"
            description="Instant identity verification across international jurisdictions"
          />
        </div>
      </div>
    </div>
  );

  const AIMonitoringView = () => (
    <div className="space-y-6">
      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4">AI-Powered Threat Detection</h3>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mb-6">
          <MetricCard label="Anomalies Detected" value="12" trend="+3%" />
          <MetricCard label="Crowd Density" value="Medium" trend="Stable" />
          <MetricCard label="Risk Score" value="Low" trend="-5%" />
        </div>
        
        <div className="space-y-4">
          <div className="p-4 bg-green-50 border border-green-200 rounded-lg">
            <h4 className="font-medium text-green-900 mb-2">Pattern Recognition Active</h4>
            <p className="text-sm text-green-700">
              AI models analyzing movement patterns, crowd behavior, and environmental factors to predict and prevent incidents.
            </p>
          </div>
          
          <div className="p-4 bg-blue-50 border border-blue-200 rounded-lg">
            <h4 className="font-medium text-blue-900 mb-2">Predictive Analytics</h4>
            <p className="text-sm text-blue-700">
              Machine learning models predict high-risk areas and times based on historical data and real-time conditions.
            </p>
          </div>

          <div className="p-4 bg-purple-50 border border-purple-200 rounded-lg">
            <h4 className="font-medium text-purple-900 mb-2">Natural Language Processing</h4>
            <p className="text-sm text-purple-700">
              AI processes tourist reports and social media to detect emerging safety concerns in real-time.
            </p>
          </div>
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h3 className="text-lg font-semibold mb-4">Emergency Response Automation</h3>
        <div className="space-y-3">
          <ResponseCard 
            trigger="Geo-fence breach in restricted zone"
            action="Automatic alert to tourist + notify local authorities"
            status="Active"
          />
          <ResponseCard 
            trigger="Panic button pressed"
            action="Dispatch emergency services + record GPS location on blockchain"
            status="Active"
          />
          <ResponseCard 
            trigger="Unusual movement pattern detected"
            action="Send check-in notification to tourist"
            status="Active"
          />
        </div>
      </div>
    </div>
  );

  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-gradient-to-r from-blue-600 to-purple-600 text-white p-6 shadow-lg">
        <div className="max-w-7xl mx-auto">
          <h1 className="text-3xl font-bold flex items-center gap-3">
            <Shield className="w-8 h-8" />
            Smart Tourist Safety Monitoring System
          </h1>
          <p className="text-blue-100 mt-2">AI-Powered Protection with Geo-Fencing & Blockchain Identity</p>
        </div>
      </header>

      <div className="max-w-7xl mx-auto p-6">
        <div className="flex gap-2 mb-6 overflow-x-auto">
          <TabButton label="Dashboard" icon={<Activity />} active={activeTab === 'dashboard'} onClick={() => setActiveTab('dashboard')} />
          <TabButton label="Geo-Fencing" icon={<MapPin />} active={activeTab === 'geofencing'} onClick={() => setActiveTab('geofencing')} />
          <TabButton label="Blockchain ID" icon={<Lock />} active={activeTab === 'blockchain'} onClick={() => setActiveTab('blockchain')} />
          <TabButton label="AI Monitoring" icon={<Radio />} active={activeTab === 'ai'} onClick={() => setActiveTab('ai')} />
        </div>

        {activeTab === 'dashboard' && <DashboardView />}
        {activeTab === 'geofencing' && <GeoFencingView />}
        {activeTab === 'blockchain' && <BlockchainView />}
        {activeTab === 'ai' && <AIMonitoringView />}
      </div>
    </div>
  );
};

const StatCard = ({ icon, label, value, color }) => (
  <div className="bg-white rounded-lg shadow p-6">
    <div className="flex items-center justify-between">
      <div>
        <p className="text-gray-600 text-sm">{label}</p>
        <p className="text-3xl font-bold mt-1">{value}</p>
      </div>
      <div className={`p-3 rounded-full bg-${color}-100 text-${color}-600`}>
        {icon}
      </div>
    </div>
  </div>
);

const TabButton = ({ label, icon, active, onClick }) => (
  <button
    onClick={onClick}
    className={`flex items-center gap-2 px-4 py-2 rounded-lg font-medium transition whitespace-nowrap ${
      active ? 'bg-blue-600 text-white' : 'bg-white text-gray-700 hover:bg-gray-50'
    }`}
  >
    {icon}
    {label}
  </button>
);

const FeatureCard = ({ title, description }) => (
  <div className="p-4 bg-gray-50 rounded-lg border">
    <h4 className="font-medium mb-2">{title}</h4>
    <p className="text-sm text-gray-600">{description}</p>
  </div>
);

const MetricCard = ({ label, value, trend }) => (
  <div className="p-4 bg-gray-50 rounded-lg">
    <p className="text-sm text-gray-600">{label}</p>
    <p className="text-2xl font-bold mt-1">{value}</p>
    <p className="text-xs text-gray-500 mt-1">{trend}</p>
  </div>
);

const ResponseCard = ({ trigger, action, status }) => (
  <div className="p-4 bg-gray-50 rounded-lg border-l-4 border-green-500">
    <div className="flex justify-between items-start mb-2">
      <p className="font-medium text-sm">Trigger: {trigger}</p>
      <span className="px-2 py-1 bg-green-100 text-green-700 text-xs rounded">{status}</span>
    </div>
    <p className="text-sm text-gray-600">Action: {action}</p>
  </div>
);

export default TouristSafetySystem;
