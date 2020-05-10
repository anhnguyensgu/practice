import axios from 'axios';

const getConfig = () => axios.get('http://localhost:3003/contentChecking');

export default {
  getConfig
};