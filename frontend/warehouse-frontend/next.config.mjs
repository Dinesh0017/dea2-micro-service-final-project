import path from "path";
import { fileURLToPath } from "url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));

/** @type {import('next').NextConfig} */
const nextConfig = {
  /* config options here */
  reactCompiler: true,
  turbopack: {
    root: __dirname,
  },
  async rewrites() {
    const gateway =
      process.env.NEXT_PUBLIC_API_GATEWAY_URL || "http://131.163.97.60:8222";
    return [
      {
        source: "/api/:path*",
        destination: `${gateway}/api/:path*`,
      },
    ];
  },
};


export default nextConfig;
