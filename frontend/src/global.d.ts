export {}

declare global {
  interface Window {
    _csrf: string
    _csrf_header: string
  }
}
