export {}

declare global {
  interface Window {
    _csrf: string
    _csrf_header: string
    _fieldErrors: Record<string, string> | null
    _formValues: Record<string, string> | null
  }
}
